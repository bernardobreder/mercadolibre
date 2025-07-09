import { render, screen } from "@testing-library/react";
import RelatedProducts from "../RelatedProducts";
import { describe, it, expect } from "vitest";

describe("RelatedProducts", () => {
  it("should render the title and the list of related products", () => {
    const products = [
      {
        id: 1,
        name: "Product Exemplo 1",
        price: 399,
        imagem: "https://via.placeholder.com/150?text=Product+1",
      },
      {
        id: 2,
        name: "Product Exemplo 2",
        price: 399,
        imagem: "https://via.placeholder.com/150?text=Product+2",
      },
      {
        id: 3,
        name: "Product Exemplo 3",
        price: 399,
        imagem: "https://via.placeholder.com/150?text=Product+3",
      },
    ];

    render(<RelatedProducts products={products} />);

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() ===
          "Products relacionados"
      )
    ).toBeInTheDocument();

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() === "Product Exemplo 1"
      )
    ).toBeInTheDocument();
  });

  it("should display a message when there are no related products", () => {
    render(<RelatedProducts products={[]} />);

    expect(
      screen.getByText(
        (_, el) =>
          el?.textContent?.replace(/\s+/g, " ").trim() ===
          "Nenhum product relacionado disponível."
      )
    ).toBeInTheDocument();
  });
});
