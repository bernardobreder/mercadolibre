type Produto = {
  id: number;
  name: string;
  price: string;
  imagem: string;
};

type Props = {
  produtos: Produto[];
};

const RelatedProducts = ({ produtos }: Props) => {
  return (
    <div className="mt-6">
      <h2 className="text-lg font-semibold mb-2">Produtos relacionados</h2>
      {produtos.length === 0 ? (
        <p>Nenhum produto relacionado disponível.</p>
      ) : (
        <div className="grid grid-cols-2 md:grid-cols-3 gap-4">
          {produtos.map((produto) => (
            <div
              key={produto.id}
              className="bg-white rounded shadow p-2 text-sm"
            >
              <img
                src={produto.imagem}
                alt={produto.name}
                className="rounded mb-2"
              />
              <p>{produto.name}</p>
              <p className="text-green-600 font-bold">{produto.price}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default RelatedProducts;
