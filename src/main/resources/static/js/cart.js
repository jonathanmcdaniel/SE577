function completeOrder() {
    var shippingVal = $('#shippingAddress').children("option:selected").val();
    var shippingId = $('#'+shippingVal).html();
    var billingVal = $('#billingAddress').children("option:selected").val();
    var billingId = $('#'+billingVal).html();

    $.post("/cart/complete", {
        shippingId: shippingId,
        billingId: billingId,
        paymentId:0
    }, function (returnstring) {
        console.log(returnstring);
    });
}