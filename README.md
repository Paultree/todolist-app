## To Do List App

To Do list app built with React w/ Bootstrap + Firestore. Purpose of application is to become familiar with the bootstrap framework and reinforce skills with forms.

# Demo and Snippets

# Requirements/Purpose

MVP:

- Create tests for both frontend and backend components - [] - not in scope
- Create a SPA to-do list - []
  - A list of all tasks that are required to be completed - []
  - A button that allows user to add a task - []
  - A button that removes a task from to-do list.
- For each task, user should be able to:
  - Edit the task description - [] - not in scope
  - Update priority - []
  - Edit colour - [] - not in scope
  - Update due date - [] - not in scope
  - A complete/finish button - []
- Create a register and login feature where unique todo lists are registered to unqiue users. - []
- Bonus:
  - Create a statistics component
    - When user hits complete button, adds a stat to total tasks completed = []
    - When user does not finish a task, adds a stat to total tasks inputted/not completed - []
    - Returns a percentage value that shows users completed tasks divided by total tasks inputted in todo list - []

# Build steps

# Design Goals/Approach

- Created backend section using Springboot. Design is similar to employee list project.

29/03/2023

- Modelling app after employee list app.
- Installed react-query and react-query firebase/firestore.
- Going to add a border to each task.
  - A green border means priority is low.
  - A red border means priority is high.
- Each task will have the following buttons:
  - Complete
  - Remove
  - Change prio
  - Update ?

5/04/2023

- Added form feature
  - A mix between react-query-firebase and useForm hook.
- Updated the query fetch line of code from Home.jsx to re-render upon form submit.

# Features

# Known Issues

# Future Goals

# Change Logs

# What did you struggle with?

# Licencing Details

# Further Details
