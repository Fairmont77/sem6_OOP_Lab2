import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import './UpdatePatron.css';

function UpdatePatron() {
  const { id } = useParams();
  const [patron, setPatron] = useState(null);

  const navigate = useNavigate();

  useEffect(() => {
    fetch(`http://localhost:3030/patrons/${id}`)
      .then(response => response.json())
      .then(data => setPatron(data))
      .catch(error => console.error('Error fetching patron:', error));
  }, [id]);

  const handleChange = e => {
    const { name, value } = e.target;
    setPatron({ ...patron, [name]: value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    fetch(`http://localhost:3030/patrons/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(patron)
    })
      .then(response => response.json())
      .then(() => navigate('/'))
      .catch(error => console.error('Error updating patron:', error));
  };

  if (!patron) return <div>Loading...</div>;

  return (
    <div className="update-patron">
      <h1>Update Patron</h1>
      <form onSubmit={handleSubmit}>
        <input type="text" name="firstName" value={patron.firstName} placeholder="First Name" onChange={handleChange} />
        <input type="text" name="lastName" value={patron.lastName} placeholder="Last Name" onChange={handleChange} />
        <input type="text" name="patronymic" value={patron.patronymic} placeholder="Patronymic" onChange={handleChange} />
        <input type="text" name="sex" value={patron.sex} placeholder="Sex" onChange={handleChange} />
        <input type="date" name="dateOfBirth" value={patron.dateOfBirth} onChange={handleChange} />
        <input type="text" name="phone" value={patron.phone} placeholder="Phone" onChange={handleChange} />
        <input type="password" name="password" value={patron.password} placeholder="Password" onChange={handleChange} />
        <button type="submit">Update Patron</button>
      </form>
    </div>
  );
}

export default UpdatePatron;
