package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PageController {

    // Root URL doğrudan login sayfasına yönlendirilir
    @GetMapping("/")
    public String root() {
        return "redirect/login"; // src/main/resources/templates/login.html mevcut
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // src/main/resources/templates/login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // src/main/resources/templates/register.html
    }

    // Authentication işlemi (sadece simüle ediyoruz)
    @PostMapping("/authenticate")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        // Basit bir kontrol (gerçek uygulamada bu kullanıcı doğrulamayı servis veya veri tabanı ile yapın)
        if ("admin".equals(username) && "123".equals(password)) {
            return "success"; // success.html'e yönlendir
        }
        // Login başarısız ise tekrar login.html'e dön
        return "login";
    }
    // Register işlemi sonrası yönlendirme
    @PostMapping("/register")
    public String processRegister(@RequestParam(value = "username", required = false) String username,
                                  @RequestParam(value = "password", required = false) String password,
                                  Model model) {
        // Basit bir mesaj
        model.addAttribute("message", "Kayıt başarılı! Şimdi giriş yapabilirsiniz.");

        // BURADA: Kullanıcıyı kaydetme işlemini gerçekleştirebilirsiniz.
        System.out.println("Kullanıcı Kaydedildi! Kullanıcı Adı: " + username); // Test için

        // Login ekranına yönlendirme
        return "login";
    }
}