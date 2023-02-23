import EmployeeController from "./employeeController.js";

function addEmployeeCard(employees) {
  const list = document.getElementById("employees-list");

  console.log(employees.length);

  let innerhtml = "";
  //The for...of loop iterates over each employee object in the employees array, and creates an HTML string for each employee using template literals.
  for (let employee of employees) {
    //The HTML string for each employee is then appended to the innerhtml string with the line innerhtml += ....
    innerhtml += `<div class="col-md-4 my-3 "> <div class="card" style="width: 18rem;">
        <img src="${employee.image}" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">ID: ${employee.id} ${employee.name} ${employee.position}</h5>
        </div>
      </div></div>`;
  }
  //After the loop completes, the innerhtml string contains a concatenation of all the HTML strings for each employee.
  console.log(innerhtml);
  //The innerhtml string is then assigned to the innerHTML property of the list element with the line list.innerHTML = innerhtml;.
  list.innerHTML = innerhtml;
}

const shapedEmployee = new EmployeeController();

async function loadEmployees() {
  try {
    const newController = await shapedEmployee.getEmployee();
    console.log(newController);
    //The addEmployeeCard function is called with the newController variable as its argument. This function takes 
    //the employee data and generates an HTML string for each employee, and then appends those HTML strings to the DOM to display the employee cards on the page.
    await addEmployeeCard(newController);
  } catch (e) {
    console.log(e);
  }
}

loadEmployees();