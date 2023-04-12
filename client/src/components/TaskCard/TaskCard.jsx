import React from "react";
import styles from "./TaskCard.module.scss";
import Button from "react-bootstrap/Button";
import { collection, doc } from "firebase/firestore";
import { db } from "../../firebase";
import { useFirestoreDocumentDeletion } from "@react-query-firebase/firestore";

const TaskCard = ({ data, id }) => {
  const collect = collection(db, "todo");

  const ref = doc(collect, `${id}`);

  const mutation = useFirestoreDocumentDeletion(ref);

  return (
    <div className={styles.TaskCard}>
      <h4>{data.task.slice(0, 1).toUpperCase() + data.task.slice(1)}</h4>
      <Button
        variant="danger"
        disabled={mutation.isLoading}
        onClick={() => {
          mutation.mutate();
        }}
      >
        X
      </Button>
    </div>
  );
};

export default TaskCard;
