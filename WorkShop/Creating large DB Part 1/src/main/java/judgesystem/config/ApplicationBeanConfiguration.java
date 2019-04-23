package judgesystem.config;


import judgesystem.util.FileUtil;
import judgesystem.util.FileUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil(){
        return new FileUtilImpl();
    }
}
