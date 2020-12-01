// eslint-disable-next-line no-unused-vars
import axios from 'axios'  
  
const SERVER_URL = 'http://localhost:9000';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
});  
  
export default {  
  // Create 
  createNew: (text, completed) => instance.post('todos', {title: text, completed: completed}),  
  // Read 
  getAll: () => instance.get('todos', {  
    transformResponse: [function (data) {  
      return data? JSON.parse(data)._embedded.todos : data;  
    }]  
  }),  
  // Update
  updateForId: (id, text, completed) => instance.put('todos/'+id, {title: text, completed: completed}),  
  // Delete
  removeForId: (id) => instance.delete('todos/'+id)  
}