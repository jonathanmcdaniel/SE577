function addUser() {
    $.get("/user/new", {
        firstName: $("#fname").val(),
        lastName: $("#lname").val(),
        phoneNumber: $("#phNumber").val()
    }, function () {
        console.log("Add User Completed");
    });
}

function saveUser() {
    $.post("/user/save", {
        firstName: $("#editfname").val(),
        lastName: $("#editlname").val(),
        phoneNumber: $("#editphNumber").val()
    });
}

function addAddress(isBilling) {
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

function showEditModal() {
    $('#editAccountModal').modal('show');
}

function deleteAddress(index) {
    var name = $('#'+index).find("#addrName").html();
    var addr1 = $('#'+index).find("#addrLine1").html();
    var city = $('#'+index).find("#addrCity").html();
    var zip = $('#'+index).find("#addrZip").html();
    var info = [name, addr1, city, zip];
    $.post("/user/deleteAddress", {
        params: info,
    });
}