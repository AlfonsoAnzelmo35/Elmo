package elmo.group.gatewaymicroservice.config;

import jakarta.persistence.Entity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity serverHttpSecurity) throws Exception {
        String[] WHITE_LIST = constructWhiteList(new String[]{"users", "products", "orders"}) ;
        serverHttpSecurity
                .authorizeExchange(auht -> auht
                        .pathMatchers(HttpMethod.GET, "/api/users", "/api/products", "/api/orders").permitAll()
                        .pathMatchers(HttpMethod.GET, "/users/swagger-ui/**").permitAll()
                        .pathMatchers(WHITE_LIST).permitAll()
                        .anyExchange().authenticated());

        serverHttpSecurity.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));//setta keyclaock come Identy provider
        serverHttpSecurity.csrf(csrf -> csrf.disable());
        serverHttpSecurity.cors(cors -> cors.configurationSource(corsConfiguration()));//abilita i cors secondo una configurazione

        return serverHttpSecurity.build();
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

    /*
    costruisce i path, uguali e consentiti, per ogni api
    i path sono nomeApi/swagger-ui e (chiamato internamente) nomeApi/v3/api-docs
    * */
    private String[] constructWhiteList(String []nameApis){
        ArrayList<String>whiteList = new ArrayList<>() ;
        for(String nameApi: nameApis){
            whiteList.add("/"+nameApi+"/swagger-ui/") ;
            whiteList.add("/"+nameApi+"/swagger-ui/**") ;
            whiteList.add("/"+nameApi+"/v3/api-docs/") ;
            whiteList.add("/"+nameApi+"/v3/api-docs/**") ;
        }
        String []whiteListArr = new String[whiteList.size()] ;
        whiteList.toArray(whiteListArr) ;
        System.out.println(Arrays.toString(whiteListArr));
        return whiteListArr;

    }
}