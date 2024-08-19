 $(document).ready(function() {

LoadAll();


 });

var baseUrlCustomer='http://localhost:8080/unnamed/customer';
$('#btnsaveCustomer').click(function (){
  saveCustomer();
  LoadAll();
});

function saveCustomer() {
   // $('#tbCustomer').empty();
    var data= $("#customerForm").serialize();
    console.log(data);
    $.ajax({
        url:baseUrlCustomer,
        method:"POST",
        data:data,
        success:function (res){
            if (res.code == 200){
                alert("SucceFully added");
           LoadAll();
           clearFeilds();

            }else {
                alert(res.data)
            }
            // console.log(res);
        },
        error:function (ob,txtStatus,error){
            alert(txtStatus);

        }
    })

}




function LoadAll() {
    $('#tbCustomer').empty();
        $.ajax({
            url: baseUrlCustomer,
            method: "GET",
            dataType: "json",//please convert the response into jason
            success: function (resp) {
                for (const customer of resp.data) {
                    // $("#tbjson").empty();
                    console.log(typeof resp);
                    let row = `<tr><td>${customer.id}</td><td>${customer.name}</td><td>${customer.address}</td><td>${customer.salary}</td></tr>`
                    $("#tbCustomer").append(row);
                }
          btnRowClick();
            }
        })



}



    function rowBack(){
        $("#tbCustomer>tr").click(function (){
            let id= $(this).children().eq(0).text();
            let name= $(this).children().eq(1).text();
            let address= $(this).children().eq(2).text();
            let salary= $(this).children().eq(3).text();

            $("#txtCid").val(id);
            $("#txtName").val(name);
            $("#txtAddress").val(address);
            $("#txtContact").val(salary);



        })


    }




$('#btnUpCustomer').click(function (){
    updateCustomer();

});

$('#btnDeleteCustomer').click(function (){
   // $('#tbCustomer').empty();
    let customerID = $("#txtCid").val();
    $.ajax({
        url:"http://localhost:8080/unnamed/customer?id="+customerID,
        method:"DELETE",
        // data:data ,
        success:function (res){
            console.log(res)
            if (res.status==200){
                alert("Succes Fully deleted");
               LoadAll();
               clearFeilds();
            }else {
                alert(res.data)
            }

        },
        error:function (ob,status,t){
            console.log(ob);
            console.log(status);
            console.log(t);

        }
    })
});
function btnRowClick (){
    $('#tbCustomer>tr').click(function (){
        let id=$(this).children(":eq(0)").text();
        let name=$(this).children(":eq(1)").text();
        let address=$(this).children(":eq(2)").text();
        let contact=$(this).children(":eq(3)").text();

        // console.log(id,name,address,contact);

        $('#txtCid').val(id);
        $('#txtName').val(name);
        $('#txtAddress').val(address);
        $('#txtContact').val(contact);

    });

}



 function remove(){
     $("#tbCustomer>tr").dblclick(function () {
         // $("#tb>tr").remove();
         // alert("fdfdf");
         $(this).remove();


     });
 }



function updateCustomer(){
    var cusOb={
        id: $('#txtCid').val(),
        name:$('#txtName').val(),
        address: $('#txtAddress').val(),
        salary:$('#txtContact').val()
    }

    $.ajax({
        url:baseUrlCustomer,
        method:"PUT",
        contentType:"application/json",//request contetnt type json
        data:JSON.stringify(cusOb),
        success:function (res){
            if (res.code=200){
                alert("SuccesFully Updated")
                 LoadAll();
                 clearFeilds();
            }else {
                alert(res.data)
            }

        },
        error:function (ob,txtStatus,error){
            alert(txtStatus);
            console.log(ob.responseText)
        }
    })

}


 $("#txtCid").on("keypress",function (e){
     if (e.key=="Enter"){
         var  customerId=$("#txtCid").val();

         $.ajax({
             url:baseUrlCustomer+"/"+customerId,
             method:"GET",
             success:function (res){
                 console.log(res);
                 if (res.code==200){
                     var customer=res.data;

                     $("#txtCid").val(customer.id);
                     $("#txtName").val(customer.name);
                     $("#txtAddress").val(customer.address);
                     $("#txtContact").val(customer.salary);
                 }

             }

         });
     }
 })

function clearFeilds() {
    $("#txtCid,#txtName,#txtAddress,#txtContact").val("");
    $('#txtCid').focus();
}



