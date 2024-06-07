import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './AddPatron.css';

function AddPatron() {
  const [patron, setPatron] = useState({
    firstName: '',
    lastName: '',
    patronymic: '',
    sex: '',
    dateOfBirth: '',
    phone: '',
    password: ''
  });

  const navigate = useNavigate();

  const handleChange = e => {
    const { name, value } = e.target;
    setPatron({ ...patron, [name]: value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    fetch('http://localhost:3030/patrons', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(patron)
    })
      .then(response => response.json())
      .then(() => navigate('/'))
      .catch(error => console.error('Error adding patron:', error));
  };

  return (
    <div className="add-patron">
      <h1>Add Patron</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" name="firstName" placeholder="First Name" onChange={handleChange} />
        <input type="text" name="lastName" placeholder="Last Name" onChange={handleChange} />
        <input type="text" name="patronymic" placeholder="Patronymic" onChange={handleChange} />
        <input type="text" name="sex" placeholder="Sex" onChange={handleChange} />
        <input type="date" name="dateOfBirth" onChange={handleChange} />
        <input type="text" name="phone" placeholder="Phone" onChange={handleChange} />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} />
        <button type="submit">Add Patron</button>
      </form>
    </div>
  );
}

export default AddPatron;
