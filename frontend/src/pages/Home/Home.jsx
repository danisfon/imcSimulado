import React from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../components/Header/Header.jsx";

const Home = () => {
    const atual = new Date();
    const dataAtual = atual.toLocaleDateString("pt-BR");
    const horaAtual = atual.toLocaleTimeString("pt-BR");

    const navigate = useNavigate();
    const chamarPaginaCalculoImc = () => {
        navigate("/imc");
    }

    return (
        <div>
            <Header pagina="Home" />
            <h3>Olá, você acessou esta página em {dataAtual} às {horaAtual}</h3>
            <button onClick={chamarPaginaCalculoImc}>Calcular IMC</button>
        </div>
    );
}

export default Home;