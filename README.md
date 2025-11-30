# TODO Web Application

A **minimal, modern Task Manager web application** built using **Spring Boot (Java)** for the backend and **plain HTML, CSS and JavaScript** for the frontend. This application allows users to **create, manage, and organize tasks** in a visually appealing, modern interface with a white and sky-blue theme.

---

## **Project Overview**

The Task Manager app is designed to help users keep track of their tasks efficiently. Each task can have:

- A **title**
- A **description**
- A **priority** (Low, Medium, High)
- A **due date**
- A **status** (TODO or DONE)

Tasks are stored in a **PostgreSQL database**, making the data persistent across sessions. The frontend is **minimal and modern**, featuring a **blurred, semi-transparent dock** that is centered both vertically and horizontally, providing a clean and elegant user experience.

---

## **Features**

1. **Add Tasks**
   - Users can input task title, description, select priority, and optionally set a due date.
2. **Mark Tasks as Done**
   - Tasks can be updated to "DONE" to indicate completion.
3. **Delete Tasks**
   - Tasks can be removed from the list permanently.
4. **Responsive & Minimal Design**
   - Semi-rounded corners and blurred background dock
   - White + sky-blue theme for modern aesthetics
5. **Persistent Storage**
   - All tasks are stored in a PostgreSQL database for reliability.
6. **Scrollable Task List**
   - Handles large number of tasks gracefully.

---

## **Tech Stack**

| Layer        | Technology                      |
|--------------|--------------------------------|
| Frontend     | HTML, CSS, JavaScript           |
| Backend      | Spring Boot (Java)              |
| Database     | PostgreSQL                      |

---

## **How It Works**

### **Frontend**
- HTML provides the structure of the page: task form and task list.
- CSS provides a modern design with a semi-transparent blurred dock, sky-blue accents, and semi-rounded corners.
- JavaScript handles all API interactions:
  - Fetch tasks from backend
  - Add new tasks
  - Delete tasks
  - Mark tasks as done

### **Backend**
- Spring Boot exposes RESTful APIs to interact with the PostgreSQL database.
- Task entities are persisted using JPA/Hibernate.
- CORS is enabled to allow frontend requests.

---


## **How to Use**

1. Open the app in a browser (`http://localhost:5500` or via Spring Boot static resources).  
2. Add tasks using the form.  
3. View tasks, mark them as done, or delete them.  
4. All tasks are stored in PostgreSQL and persist across sessions.

---


## **Setup Instructions**

This guide will help you **set up and run** the Task Manager web application locally. The app uses a **Spring Boot backend** with **PostgreSQL** and a **plain HTML/CSS/JS frontend**.

---

## **Prerequisites**

1. **Java 21** (or compatible version)  
2. **Maven**  
3. **PostgreSQL** installed and running  
5. **IntelliJ IDEA** (or another Java IDE)  

---

## **1. Clone the Repository**

```bash
git clone https://github.com/ShahriarXTahmid/task-manager.git
cd task-manager

