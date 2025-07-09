export async function getProduct(id: number) {
  const res = await fetch(`http://localhost:8080/api/products/${id}`);
  if (!res.ok) throw new Error("Erro ao buscar product");
  return res.json();
}

export default getProduct;
