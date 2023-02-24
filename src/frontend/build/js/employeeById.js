import EmployeeController from "./employeeController.js";

let idProduct = new EmployeeController();
let form = document.getElementById("product-form");

async function findByIdEmployee(event) {
  event.preventDefault();
  //The idProduct instance of EmployeeController calls its findById method with the value of the first form input field (form[0].value) converted to a number using the Number() function. The result of the method call is assigned to a variable called returnedValue.
  const returnedValue = await idProduct.findById(Number(form[0].value));
  //Number() is a built-in function in JavaScript that converts a value to a number. It can be used to convert a variety of types to a numeric value, including:
  console.log(returnedValue);

  //The values of the form input fields are set to the properties of the returnedValue object.
  form[0].value = returnedValue.id;
  form[1].value = returnedValue.name;
  form[2].value = returnedValue.position;
  form[3].value = returnedValue.image;
}

form.addEventListener("submit", findByIdEmployee);