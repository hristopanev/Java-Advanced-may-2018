package gamestore.domain.dtos;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserLoginDTO {

    private String email;
    private String password;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }


    @NotNull(message = "Email cannot be null.")
    @Pattern(regexp = "[a-zA-z0-9]+@[a-zA-z]+\\.[a-z]{2,4}", message = "Invalid Email.")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Password cannot be null.")
    @Pattern(regexp = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "password must contain at least 1 uppercase, 1 lowercase letter and 1 digit.")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
