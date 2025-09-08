import Header from './components/Header/Header.jsx'
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from './pages/Home/Home';
import Imc from './pages/Imc/Imc';

function App(){
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='/imc' element={<Imc />} />
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;