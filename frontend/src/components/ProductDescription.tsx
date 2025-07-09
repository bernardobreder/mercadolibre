type Props = {
  description: string;
};

const ProductDescription = ({ description }: Props) => {
  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-lg font-semibold mb-4">Descrição</h2>
      <p className="text-sm leading-relaxed">{description}</p>
    </div>
  );
};

export default ProductDescription;
