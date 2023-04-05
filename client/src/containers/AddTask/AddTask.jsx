import React from "react";
import styles from "./AddTask.module.scss";
import TaskForm from "../../components/TaskForm/TaskForm.jsx";

const AddTask = () => {
  return (
    <div className={styles.AddTask}>
      <h1 className={styles.AddTask_Header}>Add Task</h1>
      <TaskForm />
    </div>
  );
};

export default AddTask;
