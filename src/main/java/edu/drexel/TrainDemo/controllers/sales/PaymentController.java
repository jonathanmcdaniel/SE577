package edu.drexel.TrainDemo.controllers.sales;

import edu.drexel.TrainDemo.Utils;
import edu.drexel.TrainDemo.models.sales.CreditCard;
import edu.drexel.TrainDemo.services.sales.PaymentService;
import edu.drexel.TrainDemo.services.sales.StripeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class PaymentController {

    // Reading the value from the application.properties file
    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @Autowired
    private StripeService stripeService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/pay")
    public String home(@AuthenticationPrincipal OAuth2User principal, Model model) {

        model.addAttribute("stripePublicKey", stripePublicKey);
        return "redirect:/cart/paymentConfirmation";
    }

    @RequestMapping("/payment/addCC")
    @ResponseBody
    public void addCreditCard(@AuthenticationPrincipal OAuth2User principal, @RequestParam(value = "params[]") String[] params) {
        Long userId = Utils.intToLong(principal.getAttribute("id"));
        this.paymentService.addCreditCard(userId, Arrays.asList(params));
        //return "redirect:/cart/paymentConfirmation";
    }

    @RequestMapping("/payment/removeCC")
    @ResponseBody
    public void deleteCreditCard(@RequestParam Long creditCardId) {
        System.out.println(creditCardId);
        this.paymentService.removeCreditCard(creditCardId);
        //return "redirect:/cart/paymentConfirmation";
    }

    @RequestMapping("/user/payments")
    public String managePayments(@AuthenticationPrincipal OAuth2User principal, Model model) {
        Long userId = Utils.intToLong(principal.getAttribute("id"));
        List<CreditCard> cards = this.paymentService.getCreditCards(userId);
        model.addAttribute("cards", cards);
        return "user/payments";
    }

    @RequestMapping(value = "/charge", method = RequestMethod.POST)
    public String chargeCard(HttpServletRequest request, @RequestParam double orderAmount) throws Exception {
        String token = request.getParameter("stripeToken");

        //stripeService.chargeNewCard(token, orderAmount);
        return "result";
    }
}
