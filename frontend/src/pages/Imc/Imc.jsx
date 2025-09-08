import React, { useState, useEffect } from "react";
import ImcService from "../../service/ImcService";
import Header from '../../components/Header/Header'

const Imc = () => {
  const [imc, setImc] = useState({ nome: "", altura: 0, observacao: "", imc: 0, classificacao: ""});
  const imcService = new ImcService();

  const handleChange = (e) => {
    setImc({ ...imc, [e.target.name]: e.target.value });
  };

  const calcular = async () => {
    const resultado = await imcService.calcular(imc);
    setImc({ ...imc, imc:resultado.data.imc, calssificacao: resultado.data.classificacao });
  };

  const salvar = async () => {
    const resultado = await imcService.salvar(imc);
    setImc({ ...imc, imc:resultado.data.imc, calssificacao: resultado.data.classificacao });
  };

  const removerTodos = async () => {
    const resultado = await ImcService.removerTodos();
  };

  return (
    <div>
      <Header pagina="Calculo" />
      <h1>Faça o calculo IMC</h1>
      <label>Nome:</label><br/>
      <input value={imc.nome} onChange={handleChange} type="text" name="nome"/><br/>

      <label>Altura:</label><br/>
      <input value={imc.altura} onChange={handleChange} type="number" name="altura"/><br/>

      <label>Peso:</label><br/>
      <input value={imc.peso} onChange={handleChange} type="number" name="peso"/><br/>

      <label>Observacao:</label><br/>
      <input value={imc.observacao} onChange={handleChange} type="text" name="observacao"/><br/>

      <button onClick={calcular}>Calcular</button><br/>
      {imc.imc > 0 && <p>o imc é: {imc.imc} - {imc.classificacao}</p>}
      <button onClick={salvar}>Salvar</button>
      <button onClick={removerTodos}>Remover Todos </button>
    </div>
  );
};

export default Imc;