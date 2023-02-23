
//import addItemCard from "./items.js";
export default class EmployeeController {
    constructor(id = 0) {
      this.employees = [];
      this.id = id;
      this.localStorageEmployees = [];
    }
  
    addEmployee(name, position, image, createdAt) {
      this.id++;
      const newEmployee = {
        id: 0,
        name: "",
        position: "",
        image: "",
        createdAt: "",
      };
      newEmployee.id = this.id;
      newEmployee.name = name;
      newEmployee.position = position;
      newEmployee.image = image;
      newEmployee.createdAt = createdAt;
      this.employees.push(newEmployee);
      localStorage.setEmployee("employees", JSON.stringify(this.employees));
      this.save(newEmployee.name, newEmployee.position, newEmployee.image);
    }
  
    loadEmployeeFromLocalStorage() {
      const storageEmployees = localStorage.getEmployee("employees");
      console.log("Storage employees: " + storageEmployees);
      if (storageEmployees) {
        const gen = JSON.parse(storageEmployees);
  
        console.log(gen);
        //TODO load the items into the local items structure (this.items)
        for (let i = 0; i < gen.length; i++) {
          const shirt = gen[i];
          console.log(shirt);
          this.localStorageEmployees.push(shirt);
        }
        console.log(this.localStorageEmployees);
      }
    }
  
    //Add a new item
    save(name, position, image) {
      const data = { name, position, image };
  
      fetch("http://localhost:8080/employee", {
        method: "POST", // or 'PUT'
        headers: {
            //the data sent in json format
          "Content-Type": "application/json",
        },
        //the data object is converted into json format using JSON.stringify
        body: JSON.stringify(data),
      })
      // after the fetch function returns a promise, the promise will be 
      //handled by using then and catch methods 
      //first then extracts the data from the server 
        .then((response) => response.json())
      // second then logs data to the console 
        .then((data) => {
          console.log("Success:", data);
        })
        //catch method any errors 
        .catch((error) => {
          console.error("Error:", error);
        });
    }
  
    async update(id, name, position, image) {
      try {
        const data = { name, position, image };
        const response = await fetch(`http://localhost:8080/item/${id}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(data),
        });
        const updatedEmployee = await response.json();
        return updatedEmployee;
        throw new Error("Request failed.");
      } catch (e) {
        console.log(e);
      }
    }
  
    async findById(id) {
      try {
        const response = await fetch(`http://localhost:8080/item/${id}`);
        if (response.ok) {
          const foundEmployee = await response.json();
          return foundEmployee;
        }
        throw new Error("Request failed.");
      } catch (e) {
        console.log(e);
      }
    }
  
    //Display all items from the DB
    async getEmployee() {
      try {
        const response = await fetch("http://localhost:8080/employee/all");
        if (response.ok) {
          const employeeArr = await response.json();
          return emmployeeArr;
        }
        throw new Error("Request failed");
      } catch (error) {
        console.log(error);
      }
    }
  
    //Delete the item
    async delete(id) {
      try {
        const response = await fetch(`http://localhost:8080/item/${id}`, {
          method: "DELETE",
        });
        const deletedEmployee = await response.json();
        return deletedEmployee;
        throw new Error("Request failed.");
      } catch (e) {
        console.log(e);
      }
    }
  }