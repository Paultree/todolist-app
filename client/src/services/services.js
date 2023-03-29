import {
  doc,
  updateDoc,
  setDoc,
  collection,
  getDocs,
  getDoc,
  increment,
  deleteDoc,
  query,
} from "firebase/firestore";
import { db } from "../firebase.js";
import { useFirestoreQuery } from "@react-query-firebase/firestore";

export const getQuerySnapshot = async (data) => {
  const collectionRef = collection(db, data);
  const querySnapshot = await getDocs(collectionRef);
  return querySnapshot;
};

export const getCollection = async (data) => {
  const snapshot = await getQuerySnapshot("todo");

  const ref = query(snapshot);

  const dataQuery = useFirestoreQuery([data], ref);

  return dataQuery;
};
