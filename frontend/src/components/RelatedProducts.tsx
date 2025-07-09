import Product from "../types/Product";

type Props = {
  products: Product[];
};

const RelatedProducts = ({ products }: Props) => {
  return (
    <div className="mt-6">
      <h2 className="text-lg font-semibold mb-2">Products relacionados</h2>
      {products.length === 0 ? (
        <p>Nenhum product relacionado disponível.</p>
      ) : (
        <div className="grid grid-cols-2 md:grid-cols-3 gap-4">
          {products.map((product) => (
            <div
              key={product.id}
              className="bg-white rounded shadow p-2 text-sm"
            >
              <img
                src={product.imagem}
                alt={product.name}
                className="rounded mb-2"
              />
              <p>{product.name}</p>
              <p className="text-green-600 font-bold">{product.price}</p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default RelatedProducts;
