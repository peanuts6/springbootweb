package xqy.msa.springbootweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class RedisSessionConfig {
//	@Bean
//    RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }
}
