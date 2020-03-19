function addUser() {
    $.get("/user/new", {
        firstName: $("#fname").val(),
        lastName: $("#lname").val()
    }, function () {
        console.log("Add User Completed");
    });
}

function addAddress(isBilling) {
    console.log(isBilling);
    wait(5000);
    var info = [$("#name").val(), $("#addr1").val(), $("#addr2").val(), $("#city").val(), $("#state").children("option:selected").val(), $("#zip").val()]
    $.post("/user/newAddress", {
        params: info,
        isBilling: isBilling
    }, function () {
        console.log("done");
    });
}

function wait(ms){
    var start = new Date().getTime();
    var end = start;
    while(end < start + ms) {
        end = new Date().getTime();
    }
}

function deleteAddress(index) {
    var name = $('#'+index).find("#addrName").html();
    var addr1 = $('#'+index).find("#addrLine1").html();
    var city = $('#'+index).find("#addrCity").html();
    var zip = $('#'+index).find("#addrZip").html();
    var info = [name, addr1, city, zip];
    $.post("/user/deleteAddress", {
        params: info,
    }, function () {
        //pass
    });
}