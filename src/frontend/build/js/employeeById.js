import EmployeeController from "./employeeController.js";

let idProduct = new EmployeeController();
let form = document.getElementById("product-form");

async function findByIdEmployee(event) {
  event.preventDefault();
  const returnedValue = await idProduct.findById(Number(form[0].value));
  console.log(returnedValue);
  form[0].value = returnedValue.id;
  form[1].value = returnedValue.name;
  form[2].value = returnedValue.position;
  form[3].value = returnedValue.image;
}

form.addEventListener("submit", findByIdEmployee);