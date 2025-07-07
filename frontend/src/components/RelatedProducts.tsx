type Produto = {
  id: number;
  nome: string;
  preco: string;
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
                alt={produto.nome}
                className="rounded mb-2"
              />
              <p>{produto.nome}</p>
              <p className="text-green-600 font-bold">{produto.preco}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default RelatedProducts;
