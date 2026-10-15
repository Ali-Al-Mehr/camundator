package camundator.almehr;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        String baseUrl = request.getScheme() + "://"
                + request.getServerName() + ":"
                + request.getServerPort();

        model.addAttribute("baseUrl", baseUrl);

        return "index";
    }
}
