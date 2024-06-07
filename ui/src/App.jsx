import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import PatronList from './components/PatronList';
import AddPatron from './components/AddPatron';
import UpdatePatron from './components/UpdatePatron';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/add">Add Patron</Link>
            </li>
          </ul>
        </nav>
        <Routes>
          <Route path="/" element={<PatronList />} />
          <Route path="/add" element={<AddPatron />} />
          <Route path="/update/:id" element={<UpdatePatron />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
