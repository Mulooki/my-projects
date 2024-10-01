import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { AppComponent, User } from "../app.component";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  // Model to store user data
  model: User = {
    username: '',
    password: '',
    firstname: '',
    lastname: '',
    email: '',
    address: '',
    phone: null,
    merchant: null
  };

  options: string = null;            // Dropdown for merchant selection
  present: boolean = null;           // Username availability flag
  usernameAvailability: string;      // Message for username availability
  fontColor: string;                

  phoneValidation: boolean = true;   // Validation flag for phone number
  emailValidation: boolean = true;   // Validation flag for email
  passwordValidation: boolean = true;// Validation flag for password

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() { }

  // Check if username is already taken
  usernamePresent(): void {
    this.fontColor = '';
    const url = "http://localhost:8080/checkUserName";

    this.http.post<boolean>(url, this.model.username).subscribe(
      res => {
        this.present = res;
        if (this.present) {
          this.fontColor = "red";
          this.usernameAvailability = "Username Already Taken";
        } else {
          this.fontColor = "green";
          this.usernameAvailability = "Available";
        }
      },
      err => {
        console.error("Error checking username availability", err);
      }
    );
  }

  // Update merchant status based on the selected option
  updateSelect() {
    this.model.merchant = this.options && this.options.length !== 4;
  }

  // Validate phone number format (should be exactly 10 digits)
  checkPhone() {
    const phonePattern = /^[+ 0-9]{10}$/;
    this.phoneValidation = phonePattern.test(String(this.model.phone));
  }

  // Validate email format
  checkEmail() {
    this.emailValidation = this.model.email.length === 0 || this.model.email.includes("@");
  }

  // Validate password strength
  passwordStrength() {
    if (this.model.password.length < 8) {
      this.passwordValidation = false;
    } else {
      const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,16})/;
      this.passwordValidation = passwordPattern.test(this.model.password);
    }
  }

  // Register the user by sending their data to the backend
  registerUser(): void {
    this.updateSelect();

    // Ensure all validations pass before submitting
    if (this.phoneValidation && this.emailValidation && this.passwordValidation && !this.present) {
      const url = "http://localhost:8080/register";
      this.http.post<User>(url, this.model).subscribe(
        res => {
          AppComponent.modelUser = res;
          this.router.navigate(['welcome']);
        },
        err => {
          console.error("Error during registration", err);
          alert("An error occurred while registering");
        }
      );
    } else {
      alert("Please correct the form errors before submitting");
    }
  }
}
