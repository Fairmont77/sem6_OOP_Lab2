import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import './PatronList.css';

function PatronList() {
  const [patrons, setPatrons] = useState([]);

  useEffect(() => {
    fetch('http://localhost:3030/patrons')
      .then(response => response.json())
      .then(data => setPatrons(data))
      .catch(error => console.error('Error fetching patrons:', error));
  }, []);

  const deletePatron = id => {
    fetch(`http://localhost:3030/patrons/${id}`, { method: 'DELETE' })
      .then(() => {
        setPatrons(patrons.filter(patron => patron.id !== id));
      })
      .catch(error => console.error('Error deleting patron:', error));
  };

  return (
    <div className="patron-list">
      <h1>Patron List</h1>
      <ul>
        {patrons.map(patron => (
          <li key={patron.id}>
            {patron.firstName} {patron.lastName}
            <Link to={`/update/${patron.id}`}>Update</Link>
            <button onClick={() => deletePatron(patron.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default PatronList;
