import React from "react";
import styles from "./TaskCard.module.scss";
import Button from "react-bootstrap/Button";

const TaskCard = ({ data }) => {
  return (
    <div className={styles.TaskCard}>
      <h4>{data.task.slice(0, 1).toUpperCase() + data.task.slice(1)}</h4>
      <Button variant="danger">X</Button>
    </div>
  );
};

export default TaskCard;
