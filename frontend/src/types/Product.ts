interface Product {
  id: number;
  name: string;
  price: number;
  description: string;
  specs: {
    storage: string;
    screenSize: string;
    mainCamera: string;
    frontCamera: string;
    nfc: boolean;
  };
}

export default Product;
