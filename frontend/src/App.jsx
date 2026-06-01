// import { useState, useEffect } from 'react'
// import axios from 'axios'
//
// function App() {
//   const [index, setIndex] = useState('')
//
//   useEffect(() => {
//     const fetchIndex = () => {
//       axios.get('/api/hello')
//           .then(res => {
//             setIndex(res.data)
//           })
//           .catch(err => {
//             console.log(err)
//           })
//     }
//
//     fetchIndex(); // 초기 실행
//
//   }, [])
//
//
//   return (
//       <div>
//         백엔드 요청 확인 : {index}
//       </div>
//   )
// }

import { RouterProvider } from 'react-router-dom';
import router from './router/index';

function App() {
  return <RouterProvider router={router} />;
}

export default App;
