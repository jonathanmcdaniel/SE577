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
        $('#success').removeClass("invisible");
    });
}

function addBillingAddress(isBilling) {
    var info = [$("#billName").val(), $("#billAddr1").val(), $("#billAddr2").val(), $("#billCity").val(), $("#billState").children("option:selected").val(), $("#billZip").val()]
    $.post("/user/newAddress", {
        params: info,
        isBilling: isBilling
    }, function () {
        console.log("done");
    });
}

function addShippingAddress(isBilling) {
    var info = [$("#shipName").val(), $("#shipAddr1").val(), $("#shipAddr2").val(), $("#shipCity").val(), $("#shipState").children("option:selected").val(), $("#shipZip").val()]
    $.post("/user/newAddress", {
        params: info,
        isBilling: isBilling
    }, function () {
        console.log("done");
    });
}

function createCreditCard() {
    var info = [$('#name').val(), $('#number').val(), $('#month').children("option:selected").val(), $('#year').children("option:selected").val(), $('#cvv').val()]
    console.log(info);
    $.post("/payment/addCC", {
        params: info
    });

}