function addUser() {
    $.get("/user/new", {
        firstName: $("#fname").val(),
        lastName: $("#lname").val()
    }, function () {
        console.log("Add User Completed");
    });
}