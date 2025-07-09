type Props = {
  name: string;
  price: number;
};

const ProductMain = ({ name, price }: Props) => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <img
        className="product-img transition-transform duration-300 ease-in-out hover:scale-105 mb-6"
        src="/public/product-1.webp"
      />
      <h1 className="text-xl font-semibold mb-2">{name}</h1>
      <p className="text-green-600 text-2xl font-bold">R$ {price}</p>
      <div class="flex gap-x-4">
        <button className="bg-blue-600 text-white px-4 py-2 rounded mt-4 w-full hover:bg-blue-700 flex-1">
          Comprar agora
        </button>
        <button className="bg-transparent border border-blue-600 text-blue-600 px-4 py-2 rounded-r mt-4 w-full hover:bg-blue-100 flex-1">
          Adicionar no carrinho
        </button>
      </div>
    </div>
  );
};

export default ProductMain;
