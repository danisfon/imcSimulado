import api from "../config/axiosConfig";

class ImcService {
  async calcular(dados) {
    const response = await api.post("/imc/calcular", dados);
    return response;
  }

  async salvar(dados) {
    const response = await api.post("/imc/salvar", dados);
    return response;
  }

  async removerTodos() {
    const response = await api.delete("/imc");
    return response
  }
}

export default ImcService;