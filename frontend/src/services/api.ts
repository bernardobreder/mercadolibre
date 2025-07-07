export interface Produto {
  nome: string;
  preco: number;
  descricao: string;
  specs: string[];
}

export async function getProduto(id: number) {
  const res = await fetch(`http://localhost:8080/api/produtos/${id}`);
  if (!res.ok) throw new Error("Erro ao buscar produto");
  return res.json();
}

export default getProduto;
