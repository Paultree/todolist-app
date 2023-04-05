import React from "react";
import styles from "./TaskForm.module.scss";
import { useFirestoreCollectionMutation } from "@react-query-firebase/firestore";
import { collection } from "firebase/firestore";
import { db } from "../../firebase";
import { useForm } from "react-hook-form";
import { useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { useNavigate } from "react-router-dom";

const TaskForm = () => {
  const navigate = useNavigate();

  const toHome = () => {
    navigate("/");
  };

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const onSubmit = handleSubmit((data) => {
    mutation.mutate(data);
    toHome();
  });

  const ref = collection(db, "todo");
  const mutation = useFirestoreCollectionMutation(ref);

  return (
    <Form className={styles.Form} onSubmit={onSubmit}>
      <div className="form-group">
        <Form.Label htmlFor="task">Task:</Form.Label>
        <Form.Control id="task" {...register("task", { required: true })} />
        <Form.Label htmlFor="priority">Priority:</Form.Label>
        <Form.Select
          name="priority"
          id="priority"
          {...register("priority", { required: true })}
        >
          <option value="high">High</option>
          <option value="low">Low</option>
        </Form.Select>
      </div>
      <div className={styles.Form_Buttons}>
        <Button type="submit" className={styles.Form_Buttons_Button}>
          Submit
        </Button>
        <Button onClick={toHome} className={styles.Form_Buttons_Button}>
          Back
        </Button>
      </div>
    </Form>
  );
};

export default TaskForm;
