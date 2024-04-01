package elmo.group.product_microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class SecurityConfig {
    String[] WHITE_LIST = {
            "/v3/api-docs/**",//chiamata internamente da keycloack per richiamare la api
            "/swagger-ui/**",//chiamata per il frontend di keycloack
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auht -> auht
                        .requestMatchers(HttpMethod.GET, "/api/products").permitAll()
                        .requestMatchers(WHITE_LIST).permitAll()
                        .anyRequest().authenticated());

        httpSecurity.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));//setta keyclaock come Identy provider
        httpSecurity.csrf(csrf -> csrf.disable());
        httpSecurity.cors(cors -> cors.configurationSource(corsConfiguration()));//abilita i cors secondo una configurazione

        return httpSecurity.build();
    }

    @Bean //setta la conversione del claim, prendendo i ruoli dal jwt
    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloack() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthorityConverter = jwt -> {
            Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
            Collection<String> roles = realmAccess.get("roles");
            return roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        };
        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthorityConverter);
        return jwtAuthenticationConverter;
    }

    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8090"));//per il fututo gateway che inserirò sulla porta 8090
        configuration.setAllowedHeaders(Arrays.asList("*"));//consenti tutti i verbi di HTTP
        configuration.setAllowCredentials(true);//consenti i cookie
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}