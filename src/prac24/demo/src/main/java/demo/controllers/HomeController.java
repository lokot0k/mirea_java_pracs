package demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/home")
    public @ResponseBody String home() {
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Prac14</title>
                </head>
                <body>
                    <h3>Королев Иван ИКБО-30-22 Вариант 9</h3>
                </body>
                </html>""";
    }

}
