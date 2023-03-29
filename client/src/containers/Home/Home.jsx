import React from "react";
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/Button";
import styles from "./Home.module.scss";
import Spinner from "react-bootstrap/Spinner";
import ListGroup from "react-bootstrap/ListGroup";
import {
  getQuerySnapshot,
  useFirestoreQuery,
} from "@react-query-firebase/firestore";
import { query, collection } from "firebase/firestore";
import { db } from "../../firebase";
import TaskCard from "../../components/TaskCard/TaskCard";

const Home = () => {
  const navigate = useNavigate();

  const toAdd = () => {
    navigate("/add");
  };

  const ref = query(collection(db, "todo"));

  const payload = useFirestoreQuery(["todo"], ref);

  return (
    <div className={styles.Home}>
      <div className={styles.Home_Header}>
        <h1>To-do Tasks</h1>
      </div>
      <div className={styles.Home_Add}>
        <p className={styles.Home_Add_Para}>Click '+' to add a new task.</p>
        <Button variant="outline-primary" className={styles.Home_Add_Button}>
          +
        </Button>{" "}
      </div>
      <div>
        {payload.isLoading ? (
          <Spinner className={styles.Spinner} animation="border" />
        ) : (
          payload.data.docs.map((doc, id) => {
            const data = doc.data();
            return <TaskCard key={id} data={data} />;
          })
        )}
      </div>
    </div>
  );
};

export default Home;
