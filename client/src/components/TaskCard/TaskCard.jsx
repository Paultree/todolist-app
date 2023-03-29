import React from "react";
import styles from "./TaskCard.module.scss";

const TaskCard = ({ data }) => {
  return (
    <div className={styles.TaskCard}>
      <h4>{data.task}</h4>
    </div>
  );
};

export default TaskCard;
