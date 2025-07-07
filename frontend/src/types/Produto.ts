interface Produto {
  id: number;
  nome: string;
  preco: number;
  descricao: string;
  specs: {
    memoria: string;
    tela: string;
    cameraPrincipal: string;
    frontal: string;
    nfc: boolean;
  };
}

export default Produto;
