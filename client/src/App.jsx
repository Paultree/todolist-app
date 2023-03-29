import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import styles from "./App.module.scss";
import Home from "./containers/Home/Home";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
