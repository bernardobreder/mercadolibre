type Props = {
  name: string;
  price: number;
};

const ProductMain = ({ name, price }: Props) => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <h1 className="text-xl font-semibold mb-2">{name}</h1>
      <p className="text-green-600 text-2xl font-bold">R$ {price}</p>
      <button className="bg-blue-600 text-white px-4 py-2 rounded mt-4 w-full hover:bg-blue-700">
        Comprar agora
      </button>
    </div>
  );
};

export default ProductMain;
