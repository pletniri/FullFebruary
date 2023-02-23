import EmployeeController from "./employeeController.js";

let newProduct = new EmployeeController;
const form = document.getElementById("product-form");

function getNewProduct(event){
    //prevents the form from being submitted to the server and reloading the page, so the form submission is actually handled by the JavaScript code instead of being sent to a server. Instead, the JavaScript code reads the form input values, saves them to local storage using the addEmployee method, and updates the UI.
    event.preventDefault();
    const time = new Date();
newProduct.addEmployee(form[0].value, form[1].value, form[2].value, time);
newProduct.loadEmployeeFromLocalStorage(); //load emplloyeeFromEmployee?? 
console.log(newProduct.localStorageEmployees);
form[0].value="";
form[1].value="";
form[2].value="";
console.log(form[0].value);
};
// This code adds an event listener to the form element that listens for the submit event, which is triggered when the user submits the form by clicking the submit button or pressing the Enter key while focused on a form input field. When the submit event occurs, the getNewProduct function is called.
form.addEventListener('submit', getNewProduct);