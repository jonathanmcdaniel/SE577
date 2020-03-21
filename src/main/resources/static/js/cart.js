function completeOrder() {
    var shippingVal = $('#shippingAddress').children("option:selected").val();
    var shippingId = $('#'+shippingVal).html();
    var billingVal = $('#billingAddress').children("option:selected").val();
    var billingId = $('#'+billingVal).html();
    var paymentVal = $('#creditCard').children("option:selected").val();
    var paymentId = $('#'+paymentVal).html();

    $.post("/payment/charge", {
        paymentId: paymentId
    });

    $.post("/cart/complete", {
        shippingId: shippingId,
        billingId: billingId,
        paymentId: paymentId
    }, function (returnstring) {
        console.log(returnstring);
    });
}